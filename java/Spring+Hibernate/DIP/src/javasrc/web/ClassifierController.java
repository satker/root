package javasrc.web;

/**
 * Created by Artem on 26.11.2016.
 */

import javasrc.hiber.CharactEntity;
import javasrc.hiber.CharactValueEntity;
import javasrc.hiber.ClassifierEntity;
import javasrc.hiber.EducOdjectEntity;
import javasrc.service.CharactService;
import javasrc.service.EducOdjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javasrc.service.ClassifierService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ClassifierController {
    @Autowired
    private ClassifierService classifierService;
    @Autowired
    private EducOdjectService eoService;
    @Autowired
    private CharactService charactService;


    @RequestMapping(value = "/index", method = GET)
    public String listClassifier(Map<String, Object> map,
                                 @ModelAttribute("added") final ClassifierEntity addedClassifier) {

        map.put("classifier", new ClassifierEntity());
        map.put("added", addedClassifier);
        map.put("classifierList", classifierService.listClassifiers(1));
        return "classifier";
    }

    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index/{id}")
    public String getClassifierById1(Map<String, Object> map, ModelMap model, @PathVariable("id") Integer id) {
        ClassifierEntity classifier = classifierService.getClassifierById(id);
        model.addAttribute("id", classifier);
        map.put("classifier", new ClassifierEntity());
        map.put("classifierList", classifierService.listClassifiers(id));
        map.put("classifierListONID", classifierService.getClassifierById(id));
        map.put("eo", new EducOdjectEntity());
        map.put("eoList", eoService.listEos(id));
        map.put("eoListONID", eoService.getEoById(id));
        map.put("charactclass", new CharactEntity());
        map.put("charactclassList", charactService.listCharactClasses(id));
        return "classifier";
    }
    @RequestMapping(value = "/eo/{id}")
    public String getEoById1(Map<String, Object> map, ModelMap model, @PathVariable("id") Integer id) {
        EducOdjectEntity educOdjectEntity = eoService.getEoById(id);
        model.addAttribute("id", educOdjectEntity);
        map.put("eo", new EducOdjectEntity());
        map.put("eoListChild", eoService.listEosChild(id));
        map.put("eoListChildONID", eoService.getEoById(id));
        map.put("eoListPersonsAll", eoService.listEoPersonsAll(id));
        map.put("eoPersEO", eoService.listEoPersons(id));
        map.put("eoPosPerEO", eoService.listEoPosit(id));
        map.put("eoSubPerEO", eoService.listEoSubdiv(id));
        map.put("charact", new CharactEntity());
        map.put("charactList", charactService.listCharacts(id));
        map.put("charactvalue", new CharactValueEntity());
        map.put("charactvalueList", charactService.listCharactValues(id));
        return "classifier";
    }

    @RequestMapping(value = "/addClassifier", method = GET)
    public String updateClassifierById(Map<String, Object> map) {
        map.put("addClassifier", new ClassifierEntity());
        map.put("classifierAllList", classifierService.listAllClassifiers());
        return "addClassifier";
    }

    @RequestMapping(value = "/addClassifier", method = POST)
    public String updateClassifierById(@ModelAttribute("classifier") @Valid ClassifierEntity classifier,
                                   @RequestParam(value="name") String name, @RequestParam(value="idParent") String idParent) {
        classifierService.listAddClassifiers(name, idParent);
        return "redirect:/index";
    }

    @RequestMapping(value = "/addCharactEo", method = GET)
    public String addCharactEo(Map<String, Object> map) {
        map.put("EOAll", eoService.listEos_all());
        map.put("PersEOAll", eoService.listEoPersons_all());
        map.put("PosPerEOAll", eoService.listEoPosit_all());
        map.put("SubPerEOAll", eoService.listEoSubdiv_all());
        map.put("charactAll", charactService.listCharacts_all());
        map.put("addCharactEo", new EducOdjectEntity());
        map.put("classifierAllList", classifierService.listAllClassifiers());
        return "addCharactEo";
    }

    @RequestMapping(value = "/addCharactEo", method = POST)
    public String addCharactEo(@ModelAttribute("classifier") @Valid ClassifierEntity classifier,
                                   @RequestParam(value="name") String name, @RequestParam(value="idParent") String idParent) {
        classifierService.listAddClassifiers(name, idParent);
        return "redirect:/index";
    }


}
