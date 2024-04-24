package team4.aziendadienergia.utility;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team4.aziendadienergia.entities.Municipality;
import team4.aziendadienergia.entities.Province;
import team4.aziendadienergia.repositories.MunicipalityDAO;
import team4.aziendadienergia.repositories.ProvinceDAO;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AdressDatabaseLoader {

    @Autowired
    private MyCSVReader myCSVReader;

    @Autowired
    private MunicipalityDAO municipalityDAO;

    @Autowired
    ProvinceDAO provinceDAO;

    @PostConstruct
    public void iniettaAddress() throws Exception {
        List<Province> existingProvinces = provinceDAO.findAll();
        List<Municipality> existingMunicipalities = municipalityDAO.findAll();

        Path csvPath1 = Paths.get("src/main/java/team4/aziendadienergia/CSV/comuni-italiani.csv");
        Path csvPath2 = Paths.get("src/main/java/team4/aziendadienergia/CSV/province-italiane.csv");

        List<String[]> csvProvincia = myCSVReader.readCsv(csvPath2);
        List<String[]> csvMunicipality = myCSVReader.readCsv(csvPath1);

        List<Province> newProvinces = csvProvincia.stream()
                .map(row -> {
                    Province province = new Province();
                    province.setCodiceProvincia(row[0]);
                    province.setName(row[1]);
                    province.setRegion(row[2]);
                    return province;
                })
                .collect(Collectors.toList());

        List<Municipality> newMunicipalities = csvMunicipality.stream()
                .map(row -> {
                    Municipality municipality = new Municipality();
                    municipality.setPostalCode(String.valueOf(row[0]) + String.valueOf(row[1]));
                    municipality.setName(row[2]);
                    municipality.setProvinceCity(row[3]);
                    return municipality;
                })
                .collect(Collectors.toList());

        Set<Province> newProvincesSet = new HashSet<>(newProvinces);
        newProvincesSet.removeAll(existingProvinces);

        Set<Municipality> newMunicipalitiesSet = new HashSet<>(newMunicipalities);
        newMunicipalitiesSet.removeAll(existingMunicipalities);

        newProvincesSet.forEach(provinceDAO::save);
        newMunicipalitiesSet.forEach(municipalityDAO::save);
    }

}
