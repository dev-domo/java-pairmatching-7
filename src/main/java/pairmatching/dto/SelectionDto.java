package pairmatching.dto;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.MissionMapper;
import pairmatching.exception.CustomException;
import pairmatching.exception.ErrorMessage;

public record SelectionDto(Course course, Level level, String missionName) {

    public static SelectionDto from(String input) {
        String[] split = input.split(", ");
        Course course = Course.findByName(split[0])
                .orElseThrow(() -> new CustomException(ErrorMessage.INVALID_COURSE_OF_SELECTION));
        Level level = Level.findByName(split[1])
                .orElseThrow(() -> new CustomException(ErrorMessage.INVALID_LEVEL_OF_SELECTION));
        String mission = MissionMapper.findByLevelAndMissionName(level, split[2])
                .orElseThrow(() -> new CustomException(ErrorMessage.INVALID_LEVEL_OF_SELECTION));
        return new SelectionDto(course, level, mission);
    }
}
