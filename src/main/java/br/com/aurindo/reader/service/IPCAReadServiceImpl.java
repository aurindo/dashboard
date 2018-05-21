package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.ipca.IpcaFactor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class IPCAReadServiceImpl implements IPCAReadService {

    private static final String COMMA = "\t";

    @Override
    public Set<IpcaFactor> read(String ipcaPath) {

        Map<Integer, IpcaFactor> ipcaMap = new HashMap<>();

        File inputF = new File(ipcaPath);

        try (
                InputStream inputFS = new FileInputStream(inputF);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        ) {
            int rowIndex = 0;

            List<String[]> listLines = new ArrayList<>();
            br.lines().forEach(line -> listLines.add(line.split(COMMA)));

            for (String[] lineStr: listLines) {

                if (rowIndex == 0) {
                    processHeader(lineStr, ipcaMap);
                } else {
                    processBody(lineStr, ipcaMap);
                }

                rowIndex++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new HashSet<>(ipcaMap.values());
    }

    private void processBody(String[] cellIterator, Map<Integer, IpcaFactor> ipcaMap) {

        String opcao = "2";
        for (int colIndex = 0; colIndex < cellIterator.length; colIndex++) {

            String currentCell = cellIterator[colIndex];
            if (colIndex == 1) {
                opcao = currentCell.substring(0,1);

                if (opcao.equalsIgnoreCase("H")) {
                    opcao = "2";
                } else if (opcao.equalsIgnoreCase("V")) {
                    opcao = "4";
                }

            } else if (colIndex > 1) {
                double ipca = new Double(currentCell.replace(",","."));
                switch (opcao) {
                    case "2":
                        ipcaMap.get(colIndex).setHabitacao(ipca);
                        break;
                    case "4":
                        ipcaMap.get(colIndex).setVestuario(ipca);
                        break;
                    case "5":
                        ipcaMap.get(colIndex).setTransportes(ipca);
                        break;
                    case "8":
                        ipcaMap.get(colIndex).setEducacao(ipca);
                        break;
                }
            }
        }
    }

    private void processHeader(String[] cellIterator, Map<Integer, IpcaFactor> ipcaMap) {
        for (int colIndex = 0; colIndex < cellIterator.length; colIndex++) {

            String currentCell = cellIterator[colIndex];
            if (colIndex > 1) {

                String[] mesAnoArray = currentCell.split("/");
                String mes = mesAnoArray[0];
                Integer ano = new Integer(mesAnoArray[1]);
                ipcaMap.put(colIndex, new IpcaFactor(mes, ano));
            }
        }
    }
}
