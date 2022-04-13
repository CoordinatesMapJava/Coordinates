package com.coord.file;

import com.coord.model.Coord;
import com.coord.model.Sismica2d;
import com.coord.service.Sismica2dService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.coord.service.CoordService;

@Component
public class ReadFile {

    public Map<String, ArrayList<Coord>> readCoord(String path, 
            Sismica2dService serviceSismica, CoordService serviceCoord) 
            throws IOException {

        Map<String, ArrayList<Coord>> dadosCoord = new HashMap<>();

        try ( BufferedReader buffRead = new BufferedReader(new FileReader(path))) {

            String linha = "";

            while ((linha = buffRead.readLine()) != null) {

                if (!linha.startsWith("H")) {

                    String nome = linha.substring(1, 13).trim();
                    String lat = linha.substring(25, 35).trim();
                    String lon = linha.substring(35, 46).trim();
                    Double x = Double.parseDouble(linha.substring(46, 55).trim());
                    Double y = Double.parseDouble(linha.substring(55, 64).trim());
                    Double z = Double.parseDouble(linha.substring(64, 70).trim());
                    Integer stn = Integer.parseInt(linha.substring(19, 25).trim());
              
                    ArrayList<Coord> listaCoord = dadosCoord.get(nome);

                    if (listaCoord == null) {
                        listaCoord = new ArrayList<>();
                        dadosCoord.put(nome, listaCoord);
                    }
                    
                    listaCoord.add(new Coord(null, lat, lon, x, y, z, stn, null));

                }

            }
            
            buffRead.close();

            for (Map.Entry <String, ArrayList<Coord>> entry: dadosCoord.entrySet()) {
                
                String key = entry.getKey(); // key = nome
                ArrayList <Coord> value = entry.getValue(); // value = dadosCoord
                
                // referenciando s2d (id) para a tabela coord
                Sismica2d s2d = serviceSismica.getByNome(key);
                
                if (s2d == null) {
                    
                    s2d = new Sismica2d(null, key);
                    s2d = serviceSismica.save(s2d);
                
                }
                
                for (int i = 0; i < value.size(); i++) {
                    
                    Coord get = value.get(i);
                    get.setSismica2d(s2d);
                  
                    serviceCoord.save(get);
                    
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("Erro em ler arquivo!");
            e.printStackTrace();
        }

        return dadosCoord;

    }

}
