package com.coord.main;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.coord.service.CoordService;

@Component
public class RunTest implements CommandLineRunner {

//  @Autowired
//  private Sismica2dService serviceSisimica;
    
    @Autowired
    private CoordService serviceCoord;

    @Override
    public void run (String... args) throws Exception, IOException, SQLException {
        
        String path = "/Z/soarescarol/compartilhado/0294_POT_302_BOA_VISTA_2D.UKOOA.txt";
        //Map <String, ArrayList<Coord>> dadosCoord = new ReadFile().readCoord(path, serviceSisimica, serviceCoord);
        //System.out.println(serviceSismica.getByNome("0294-0182"));
        System.out.println(serviceCoord.getBySismica2dEndsCoord("0294-0182"));
        
    }
    
    
    
    
}
