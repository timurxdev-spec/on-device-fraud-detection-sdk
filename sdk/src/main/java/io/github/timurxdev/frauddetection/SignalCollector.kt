package io.github.timurxdev.frauddetection

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.MotionEvent
import kotlin.math.sqrt

/**
 * Collects behavioral signals from touch events and device sensors.
 * All data is stored locally and never transmitted off the device.
 */
class SignalCollector(context: Context) : SensorEventListener {

    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    private val touchEvents = mutableListOf<TouchEvent>()
    private val motionEvents = mutableListOf<MotionEventData>()

    fun start() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    fun stop() {
        sensorManager.unregisterListener(this)
    }

    fun recordTouch(event: MotionEvent) {
        touchEvents.add(
            TouchEvent(
                x = event.x,
                y = event.y,
                pressure = event.pressure,
                timestamp = event.eventTime
            )
        )
    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            val magnitude = sqrt(
                it.values[0] * it.values[0] +
                it.values[1] * it.values[1] +
                it.values[2] * it.values[2]
            )
            motionEvents.add(MotionEventData(magnitude, it.timestamp))
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not used in this prototype
    }

    fun getTouchEvents(): List<TouchEvent> = touchEvents.toList()
    fun getMotionEvents(): List<MotionEventData> = motionEvents.toList()

    data class TouchEvent(
        val x: Float,
        val y: Float,
        val pressure: Float,
        val timestamp: Long
    )

    data class MotionEventData(
        val magnitude: Float,
        val timestamp: Long
    )
}
