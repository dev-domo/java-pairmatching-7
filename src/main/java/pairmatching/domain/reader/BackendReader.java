package pairmatching.domain.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.constants.Course;
import pairmatching.domain.Crew;

public class BackendReader {

    public List<Crew> read(){
        List<Crew> result = new ArrayList<>();
        Set<String> crewsForCheckDuplication = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ResourcePath.BACKEND_CREW.getPath()));

            String line;
            while ((line = br.readLine()) != null) {
                String name = line;
                crewsForCheckDuplication.add(name);

                result.add(new Crew(Course.BACKEND,name));
            }
            if(result.size() != crewsForCheckDuplication.size()){
                throw new IllegalArgumentException("벡엔드 멤버 중독");
            }

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
