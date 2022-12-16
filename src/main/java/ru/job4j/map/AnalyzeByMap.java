package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalSum = 0D;
        int count = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                totalSum += s.score();
                count++;
            }
        }
        return totalSum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sum = 0D;
        double average = 0D;
        List<Label> averageByPupil = new ArrayList<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                sum += s.score();
                average = sum / p.subjects().size();
            }
            averageByPupil.add(new Label(p.name(), average));
            sum = 0;
            average = 0;
        }
        return averageByPupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsMap = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjectsMap.containsKey(subject.name())) {
                    subjectsMap.put(subject.name(), subjectsMap.get(subject.name()) + subject.score());
                } else {
                    subjectsMap.put(subject.name(), subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> entrySet : subjectsMap.entrySet()) {
            result.add(new Label(entrySet.getKey(), entrySet.getValue() / subjectsMap.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0D;
        List<Label> pupilsMarks = new ArrayList<>();
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                sum += s.score();
            }
            pupilsMarks.add(new Label(p.name(), sum));
            sum = 0;
        }
        pupilsMarks.sort(Comparator.naturalOrder());
        return pupilsMarks.get(pupilsMarks.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsMap = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subjectsMap.getOrDefault(subject.name(), 0);
                subjectsMap.put(subject.name(), score + subject.score());
            }
            for (Map.Entry<String, Integer> entrySet : subjectsMap.entrySet()) {
                result.add(new Label(entrySet.getKey(), entrySet.getValue()));
            }
            result.sort(Comparator.naturalOrder());

        }
        return result.get(result.size() - 1);
    }
}