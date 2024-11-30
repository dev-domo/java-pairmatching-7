package pairmatching.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pairmatching.domain.reader.BackendReader;
import pairmatching.domain.reader.FrontendReader;

class CrewsByCourseTest {
    private CrewsByCourse crewsByCourse;

    @Test
    void 파일_읽어오기_확인(){
        crewsByCourse = new CrewsByCourse(
                new BackendReader(),
                new FrontendReader());

        System.out.println(crewsByCourse);
    }

}