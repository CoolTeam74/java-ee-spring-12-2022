package org.example.config;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

@Stateless
public class Statistics {
    @Schedule(dayOfMonth = "1", hour = "12", minute = "0")
    public void calculateItemsSold() {
        // todo: bussiness logic
    }

    @Schedules ({
            @Schedule(hour = "2"),
            @Schedule(dayOfMonth = "15", dayOfWeek = "Web", hour = "14")
    })
    public void generateReport() {
        // todo: bussiness logic
    }

    @Schedule(minute = "*/10", hour = "*", persistent = false)
    public void refreshCache() {
        // todo: clear cache
    }
 }
