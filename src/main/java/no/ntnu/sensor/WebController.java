package no.ntnu.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    /**
     * Responsible for displaying data.
     */
    @Autowired
    private SensorService sensorService;

    /**
     * Creates a graph of how many people are estimated to be inside area and returns the HTML file.
     *
     * @param model Model of the page.
     * @return index HTML file.
     */
    @RequestMapping("/")
    public String getHome(Model model) {

        List<SensorData> sensorData = sensorService.getAll();
        List<Integer> xValues = new ArrayList<>();
        List<Integer> yValues = new ArrayList<>();

        sensorData.forEach(sensor -> {
            xValues.add(sensor.getTime().getHour());
            yValues.add(sensor.getTotalPeople());

        });

        model.addAttribute("allsensorlist", sensorService.getAll());
        model.addAttribute("xValues", xValues);
        model.addAttribute("yValues", yValues);

        return "index";
    }

}
