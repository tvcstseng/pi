package com.ttstudios.pi.temperature;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ttstudios.pi.temperature.drivers.DS1820;
import com.ttstudios.pi.temperature.drivers.DS1820Dto;

public class TemperatureManager {
    private static final Logger LOG = LogManager.getLogger( TemperatureManager.class );

    public static final String SENSOR_TYPE_DS1820 = "DS1820";

    private TemperatureSensor sensor;

    public TemperatureManager() {
        LOG.debug( "#### TemperatureManager Sensor: NONE" );
    }

    public TemperatureManager(String sensorType) throws URISyntaxException, IOException {
        LOG.debug( "#### TemperatureManager Sensor: " + SENSOR_TYPE_DS1820 );
        
        if ( SENSOR_TYPE_DS1820.equals( sensorType ) ) {
            sensor = new DS1820();
        }
        else{
            throw new UnsupportedOperationException("Unsupported sensor: " + sensorType);
        }
    }

    public DS1820Dto readTemperature() throws IOException {
        LOG.info("readTemperature");
        return sensor.readTemperature();
    }
    
    public String printTemperature() throws IOException {
        return sensor.printTemperature();
    }
}
