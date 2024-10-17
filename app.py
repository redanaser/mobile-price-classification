from flask import Flask, request, jsonify
import pandas as pd
import numpy as np
import joblib
from sklearn.preprocessing import StandardScaler
from preprocessing import feature_engineering
app = Flask(__name__)

# Load the trained SVC model and scaler
svc_model = joblib.load('models/svc_model.pkl')
scaler = joblib.load('models/scaler.pkl')
bin_edges=joblib.load('models/bin_edges.pkl')



@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()
    input_data = pd.DataFrame(data)
    # Fill NaNs with the median and keep only relevant columns

    # Preprocess the input data
    processed_data ,_, _ = feature_engineering(input_data, fit_scaler=False, scaler=scaler, bin_edges=bin_edges)
    # Make prediction
    prediction = svc_model.predict(processed_data)
    predicted_price = prediction.tolist()

    # Return the predicted price as a JSON response
    return jsonify({"predicted_price": predicted_price})

if __name__ == "__main__":
    app.run(debug=True)
