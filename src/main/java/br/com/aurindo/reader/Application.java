package br.com.aurindo.reader;

import br.com.aurindo.reader.service.CotacaoDolarProcessService;
import br.com.aurindo.reader.service.IPCAProcessService;
import br.com.aurindo.reader.service.PIBProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.exit;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application implements CommandLineRunner {

    @Autowired
    private IPCAProcessService ipcaProcessService;

    @Autowired
    private CotacaoDolarProcessService cotacaoDolarProcessService;

    @Autowired
    private PIBProcessService pibProcessService;

    @Value("${path.ipca1}")
    private String ipca1path;

    @Value("${path.ipca2}")
    private String ipca2path;

    @Value("${path.ipca3}")
    private String ipca3path;

    @Value("${path.ipca4}")
    private String ipca4path;

    @Value("${path.cotacaoDolar}")
    private String cotacaoDolar;

    @Value("${path.pib}")
    private String pibPath;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Inicio processamento dados PIB");
        pibProcessService.processPIB(pibPath);
        System.out.println("Fim processamento dados PIB");

        System.out.println("Inicio processamento dados IPCA");
        List<String> ipcaPathSet = new ArrayList<>();
        ipcaPathSet.add(ipca1path);
        ipcaPathSet.add(ipca2path);
        ipcaPathSet.add(ipca3path);
        ipcaPathSet.add(ipca4path);
        ipcaProcessService.processIPCA(ipcaPathSet);
        System.out.println("Fim processamento dados IPCA");

        System.out.println("Inicio processamento dados Cotacao Dolar");
        cotacaoDolarProcessService.processCotacaoDolar(cotacaoDolar);
        System.out.println("Fim processamento dados Cotacao Dolar");

        exit(0);
    }

}
