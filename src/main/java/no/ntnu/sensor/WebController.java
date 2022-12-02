package no.ntnu.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private SensorService sensorService;

    @RequestMapping("/")
    public String getHome(Model model) {

        List<SensorData> sensorData = sensorService.getAll();
        List<Integer> xValues = new ArrayList<>();
        List<Integer> yValues = new ArrayList<>();

        sensorData.forEach(sensor -> {
            xValues.add(sensor.getDateAndTime().getHour());
            yValues.add(sensor.getTotalPeople());

        });

        model.addAttribute("allsensorlist", sensorService.getAll());
        model.addAttribute("xValues", xValues);
        model.addAttribute("yValues", yValues);

        return "index";
    }

}
