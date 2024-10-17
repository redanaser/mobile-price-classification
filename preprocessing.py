import pandas as pd
import numpy as np
import joblib
from sklearn.preprocessing import StandardScaler


def feature_engineering(df, fit_scaler=True, scaler=None, bin_edges=None):
    # Calculate pixel density
    
    df = df[['battery_power', 'px_height', 'px_width', 'ram']]
    df = df.fillna(df.median())
    df['pixel_density'] = df['px_height'] + df['px_width']
    
    # Log transformation
    df['log_ram'] = np.log1p(df['ram'])
    df['log_battery_power'] = np.log1p(df['battery_power'])

    # Binning logic
    if bin_edges is None:  # During training, calculate the bin edges
        df['battery_power_bins'], battery_power_bins_edges = pd.qcut(df['battery_power'], q=4, labels=False, retbins=True, duplicates='drop')
        df['ram_bins'], ram_bins_edges = pd.qcut(df['ram'], q=4, labels=False, retbins=True, duplicates='drop')
        
        # Save these edges for later use
        bin_edges = {
            'battery_power': battery_power_bins_edges,
            'ram': ram_bins_edges
        }
    else:  # During prediction, reuse the saved bin edges
        df['battery_power_bins'] = pd.cut(df['battery_power'], bins=bin_edges['battery_power'], labels=False, include_lowest=True)
        df['ram_bins'] = pd.cut(df['ram'], bins=bin_edges['ram'], labels=False, include_lowest=True)

    # Drop original columns
    df = df.drop(columns=['px_height', 'px_width'], axis=1)
    df = df.fillna(df.median())
    # List of numerical features to scale
    numerical_features = ['battery_power', 'pixel_density', 'log_ram', 'log_battery_power', 'ram']  # Adjust as needed

    # Scale numerical features
    if fit_scaler:
        scaler = StandardScaler()
        df[numerical_features] = scaler.fit_transform(df[numerical_features])
    else:
        df[numerical_features] = scaler.transform(df[numerical_features])

    return df, scaler, bin_edges  # Return bin_edges and scaler when training

