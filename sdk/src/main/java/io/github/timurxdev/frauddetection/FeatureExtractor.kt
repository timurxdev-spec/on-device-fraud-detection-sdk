package io.github.timurxdev.frauddetection

/**
 * Extracts a lightweight feature vector from raw behavioral signals.
 * This is a placeholder — actual feature engineering will be added in future iterations.
 */
object FeatureExtractor {

    /**
     * Converts a list of touch events into a normalized feature vector.
     * For now, returns basic statistics: average pressure, average speed, variance of intervals.
     */
    fun extractTouchFeatures(events: List<SignalCollector.TouchEvent>): FloatArray {
        if (events.isEmpty()) return FloatArray(0)

        val pressures = events.map { it.pressure }
        val avgPressure = pressures.average().toFloat()

        val intervals = events.zipWithNext { a, b -> (b.timestamp - a.timestamp).toFloat() }
        val avgInterval = if (intervals.isNotEmpty()) intervals.average().toFloat() else 0f
        val variance = if (intervals.isNotEmpty()) {
            intervals.map { (it - avgInterval) * (it - avgInterval) }.average().toFloat()
        } else 0f

        return floatArrayOf(avgPressure, avgInterval, variance)
    }

    /**
     * Converts motion events into a simple feature vector.
     * Placeholder: average magnitude and variance.
     */
    fun extractMotionFeatures(events: List<SignalCollector.MotionEventData>): FloatArray {
        if (events.isEmpty()) return FloatArray(0)

        val magnitudes = events.map { it.magnitude }
        val avgMag = magnitudes.average().toFloat()
        val variance = magnitudes.map { (it - avgMag) * (it - avgMag) }.average().toFloat()

        return floatArrayOf(avgMag, variance)
    }
}
