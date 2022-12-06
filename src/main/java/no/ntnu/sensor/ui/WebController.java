package no.ntnu.sensor.ui;

import no.ntnu.sensor.sensorData.SensorData;
import no.ntnu.sensor.sensorData.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a REST API Controller - returns the HTML file
 */

@Controller
public class WebController {

    /**
     * Responsible for displaying data.
     */
    @Autowired
    private SensorDataService sensorDataService;

    /**
     * Creates a graph of how many people are estimated to be inside area and returns the HTML file.
     *
     * @param model Model of the page.
     * @return index HTML file.
     */
    @RequestMapping("/")
    public String getHome(Model model) {

        List<SensorData> sensorData = sensorDataService.getAll();
        List<Integer> xValues = new ArrayList<>();
        List<Integer> yValues = new ArrayList<>();

        sensorData.forEach(sensor -> {
            xValues.add(sensor.getTime().getHour());
            yValues.add(sensor.getTotalPeople());

        });

        model.addAttribute("allsensorlist", sensorDataService.getAll());
        model.addAttribute("xValues", xValues);
        model.addAttribute("yValues", yValues);

        return "index";
    }

}
