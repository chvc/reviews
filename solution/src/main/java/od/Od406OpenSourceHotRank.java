package od;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * #P00286—开源项目热度榜单
 *
 * @author chenghu
 * @since 2025-09-14 12:40:20
 */
public class Od406OpenSourceHotRank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] w = sc.nextLine().split("\\s+");
        int watchWeight = Integer.parseInt(w[0]);
        int starWeight = Integer.parseInt(w[1]);
        int forkWeight = Integer.parseInt(w[2]);
        int issueWeight = Integer.parseInt(w[3]);
        int mrWeight = Integer.parseInt(w[4]);
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split("\\s+");
            String name = split[0];
            Integer watch = Integer.parseInt(split[1]);
            Integer star = Integer.parseInt(split[2]);
            Integer fork = Integer.parseInt(split[3]);
            Integer issue = Integer.parseInt(split[4]);
            Integer mr = Integer.parseInt(split[5]);
            projects.add(new Project(name, watch * watchWeight + star * starWeight + fork * forkWeight + issueWeight * issue + mr * mrWeight));
        }
        List<Project> entries = projects.stream().sorted().collect(Collectors.toList());
        for (Project p : entries) {
            System.out.println(p.name);
        }
    }

    static class Project implements Comparable<Project> {
        String name;
        int hot;

        Project(String name, int hot) {
            this.name = name;
            this.hot = hot;
        }

        @Override
        public int compareTo(Project o) {
            if (o.hot != this.hot) {
                return o.hot - this.hot;
            }
            return this.name.toLowerCase().compareTo(o.name.toLowerCase());
        }
    }

}
