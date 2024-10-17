package com.example.demo.controller;

import com.example.demo.entity.Device;
import com.example.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/**
 * Controller for handling Device-related endpoints.
 */
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    // Update with your Flask API's prediction URL
    private static final String FLASK_API_URL = "http://localhost:5000/predict"; // Replace with your Flask API URL

    /**
     * GET /api/devices - Retrieve a list of all devices.
     *
     * @return List of all devices
     */
    @GetMapping
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    /**
     * GET /api/devices/{id} - Retrieve details of a specific device by ID.
     *
     * @param id Device ID
     * @return ResponseEntity with the device details or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        return device.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * POST /api/devices - Add a new device.
     *
     * @param device Device entity to add
     * @return The newly created device
     */
    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    /**
     * POST /api/predict/{deviceId} - Predict the price for a device by calling the Flask API.
     *
     * @param deviceId ID of the device to predict the price for
     * @return ResponseEntity with the updated device including the predicted price
     */
    @PostMapping("/predict/{deviceId}")
    public ResponseEntity<Device> predictPrice(@PathVariable Long deviceId) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceId);

        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();

            // Prepare the data to be sent to the Flask API
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Device> request = new HttpEntity<>(device);

            // Send the device data to Flask API and receive the predicted price range
            ResponseEntity<String> response = restTemplate.postForEntity(FLASK_API_URL, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                // Update device with the predicted price range
                device.setPriceRange(response.getBody());
                deviceRepository.save(device);
                return ResponseEntity.ok(device);
            } else {
                return ResponseEntity.status(response.getStatusCode()).build();
            }

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
