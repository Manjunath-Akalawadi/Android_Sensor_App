package com.demo.manju.sensor_app;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView accX , accY , accZ , gyroX , gyroY , gyroZ ,
                    magX , magY , magZ , sLight , sPressure , sTemp , sHum;

    private Sensor accelerometer , gyroscope , magnetometer , light , pressure , temperature , humidity ;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accX = (TextView) findViewById(R.id.accX);
        accY = (TextView) findViewById(R.id.accY);
        accZ = (TextView) findViewById(R.id.accZ);

        gyroX = (TextView) findViewById(R.id.gyrX);
        gyroY = (TextView) findViewById(R.id.gyrY);
        gyroZ = (TextView) findViewById(R.id.gyrZ);

        magX = (TextView) findViewById(R.id.magX);
        magY = (TextView) findViewById(R.id.magY);
        magZ = (TextView) findViewById(R.id.magZ);

        sLight = (TextView) findViewById(R.id.sLigth);
        sPressure = (TextView) findViewById(R.id.sPressure);
        sTemp = (TextView) findViewById(R.id.sTemp);
        sHum = (TextView) findViewById(R.id.sHum);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null){
            sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            accX.setText("Accelerometer not Supported");
        }

        gyroscope= sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null){
            sensorManager.registerListener(MainActivity.this,gyroscope,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            gyroX.setText("Gyroscope not Supported");
        }

        magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (magnetometer != null){
            sensorManager.registerListener(MainActivity.this,magnetometer,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            magX.setText("Magnetometer not Supported");
        }

        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (light != null){
            sensorManager.registerListener(MainActivity.this,light,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            sLight.setText("Light Sensor not Supported");
        }

        pressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (pressure != null){
            sensorManager.registerListener(MainActivity.this,pressure,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            sPressure.setText("Pressure not Supported");
        }

        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (magnetometer != null){
            sensorManager.registerListener(MainActivity.this,magnetometer,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            sTemp.setText("Temperature not Supported");
        }

        humidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (magnetometer != null){
            sensorManager.registerListener(MainActivity.this,humidity,SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            sHum.setText("Humidity not Supported");
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accX.setText("x:"+event.values[0]);
            accY.setText("y:"+event.values[1]);
            accZ.setText("z:"+event.values[2]);
        }

         else if (sensor.getType() == Sensor.TYPE_GYROSCOPE){
            gyroX.setText("x:"+event.values[0]);
            gyroY.setText("y:"+event.values[1]);
            gyroZ.setText("z:"+event.values[2]);
        }

        else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magX.setText("x:"+event.values[0]);
            magY.setText("y:"+event.values[1]);
            magZ.setText("z:"+event.values[2]);
        }

        else if (sensor.getType() == Sensor.TYPE_LIGHT){
            sLight.setText(""+event.values[0]);
        }

        else if (sensor.getType() == Sensor.TYPE_PRESSURE){
            sPressure.setText(""+event.values[0]);
        }

        else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
            sTemp.setText(""+event.values[0]);
        }

        else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY){
            sHum.setText(""+event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
