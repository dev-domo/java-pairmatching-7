package pairmatching.manager;

import pairmatching.constant.Course;
import pairmatching.reader.BackEndCrewReader;
import pairmatching.reader.FrontEndCrewReader;
import pairmatching.repository.CrewRepository;

public class PairMatchingCreator {

    private final CrewRepository crewRepository = CrewRepository.getInstance();

    public PairMatchingCreator() {
        crewRepository.clear();
    }

    public void initCrews() {
        crewRepository.save(Course.BACKEND, new BackEndCrewReader().read());
        crewRepository.save(Course.FRONTEND, new FrontEndCrewReader().read());
    }
}
