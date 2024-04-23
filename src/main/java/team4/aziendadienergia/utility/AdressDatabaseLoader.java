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
import java.util.List;

@Component
public class AdressDatabaseLoader {

    @Autowired
    private MyCSVReader myCSVReader;

    @Autowired
    private MunicipalityDAO municipalityDAO;

    @Autowired
    ProvinceDAO provinceDAO;

    @PostConstruct
    public void iniettaAdress() throws Exception {
        Path csvPath1 = Paths.get("src/main/java/team4/aziendadienergia/CSV/comuni-italiani.csv");
        Path csvPath2 = Paths.get("src/main/java/team4/aziendadienergia/CSV/province-italiane.csv");

        List<String[]> csvProvincia = myCSVReader.readCsv(csvPath2);
        csvProvincia.forEach(rigaCSVProvincia -> {
            Province province = new Province();
            province.setCodiceProvincia(rigaCSVProvincia[0]);
            province.setName(rigaCSVProvincia[1]);
            province.setCountry(rigaCSVProvincia[2]);
            provinceDAO.save(province);
        });

        List<String[]> csvMunicipality = myCSVReader.readCsv(csvPath1);
        csvMunicipality.forEach(rigaCSVMunicipality -> {
            Municipality municipality = new Municipality();
            municipality.setPostalCode(String.valueOf(rigaCSVMunicipality[0] ) + String.valueOf(rigaCSVMunicipality[1]));;
            municipality.setName(rigaCSVMunicipality[2]);
            municipality.setProvinceCity(rigaCSVMunicipality[3]);
            municipalityDAO.save(municipality);
        });

    }
}
