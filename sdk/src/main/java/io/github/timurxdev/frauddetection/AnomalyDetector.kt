package io.github.timurxdev.frauddetection

/**
 * On-device anomaly detection module.
 * Placeholder — will be replaced with a TensorFlow Lite model in future versions.
 */
class AnomalyDetector {

    /**
     * Evaluates whether the current session deviates from the user's behavioral baseline.
     * Returns a score between 0.0 (normal) and 1.0 (highly anomalous).
     *
     * Currently returns a dummy value. Real implementation will use a locally stored model.
     */
    fun evaluate(features: FloatArray): Float {
        // TODO: integrate TensorFlow Lite model
        return 0.0f
    }

    /**
     * Updates the local behavioral profile with new data.
     * To be implemented with on-device incremental learning.
     */
    fun updateBaseline(features: FloatArray) {
        // TODO: implement adaptive baseline update
    }
}
