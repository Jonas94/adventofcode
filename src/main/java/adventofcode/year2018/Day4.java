package adventofcode.year2018;

import adventofcode.utils.FileHandler;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4 {

    public static void main(String[] args) {
        List<String> rows = FileHandler.readFileIntoList("adventofcode/year2018/inputDay4.txt");
        Map<Integer, SleepyGuard> guards = new HashMap<Integer, SleepyGuard>();
        int minutesAsleep;
        int id;
        SleepyGuard guard = null;


        rows.sort(Comparator.naturalOrder());
        
        for (int i = 0; i < rows.size(); i++) {
            Pattern patternID = Pattern.compile("#\\d+");
            Matcher matcherID = patternID.matcher(rows.get(i));

            if (matcherID.find()) {
                id = Integer.parseInt(matcherID.group(0).substring(1));

                if (!guards.containsKey(id)) {
                    guard = new SleepyGuard();
                    guard.setId(id);
                    guards.put(id, guard);
                } else {
                    guard = guards.get(id);
                }
            }

            if (rows.get(i).contains("falls asleep")) {
                int startSleep = Integer.parseInt(rows.get(i).substring(15, 17));
                int stopSleep = Integer.parseInt(rows.get(i + 1).substring(15, 17));
                minutesAsleep = stopSleep - startSleep;
                int[] minutes = new int[minutesAsleep];
                for (int j = 0, minute = startSleep; minute < stopSleep; minute++, j++) {
                    minutes[j] = minute;
                }
                guard.addSleepingMinutes(minutes);
            }
        }

        int highestSleepMinutes = 0;
        int idHighestSleepMinutes = 0;
        for (int key : guards.keySet()) {
            guard = guards.get(key);

            if (guard.getTotalSleepingMinutes() > highestSleepMinutes) {
                highestSleepMinutes = guard.getTotalSleepingMinutes();
                idHighestSleepMinutes = key;
            }

        }
        System.out.println("GUARD ID: " + idHighestSleepMinutes);
        System.out.println("Minutes asleep: " + highestSleepMinutes);

        guard = guards.get(idHighestSleepMinutes);

        int minuteMostSlept = Integer.parseInt(guard.getMostSleptMinute().firstKey().toString());
        System.out.println("Result part 1: " + idHighestSleepMinutes * minuteMostSlept);

        int highestMinuteSleepCount = 0;
        int highestMinuteSleepCountGuardID = 0;

        for (int key : guards.keySet()) {
            guard = guards.get(key);

            if (Integer.parseInt(guard.getMostSleptMinute().firstEntry().getValue().toString()) > highestMinuteSleepCount) {
                highestMinuteSleepCount = Integer.parseInt(guard.getMostSleptMinute().firstEntry().getValue().toString());
                highestMinuteSleepCountGuardID = key;
            }
        }
        guard = guards.get(highestMinuteSleepCountGuardID);

        System.out.println("Guard ID: " + guard.getId());
        System.out.println("Highest sleep count on minute: " + guard.getMostSleptMinute().firstKey());
        System.out.println("Result part 2: " + guard.getId() * Integer.parseInt(guard.getMostSleptMinute().firstKey().toString()));
    }
}
