import java.util.Scanner;

public class TestClass{

    public static int []num = new int[2005];


    public static void main(String[]  args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int[] vis = new int[2005];

            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = n + 1;
            for(int i = 0; i < n; i++){
                num[i] = sc.nextInt();
            }
            int start = 0, ends = 0;
            int appear = 0;
            while (ends < n){
                if(num[ends] == 0){
                    ends++;
                    vis = new int[2005];
                    start = ends;
                    appear = 0;

                    continue;
                }
                if(vis[num[ends]] == 0){
                    appear += 1;
                    vis[num[ends]]++;
                }else{
                    vis[num[ends]]++;
                }
                ends++;
                if(appear == m){
                    while (appear == m){
                        if(vis[num[start]] == 1){
                            answer = Math.min(ends-start, answer);
                            start++;
                            appear--;
                        }else{
                            vis[num[start]]--;
                            start++;
                        }
                    }
                }
            }

            if(answer == (n + 1)){
                System.out.println(-1);
            }else{
                System.out.println(answer);
            }
        }
    }
    //2017年4月-2017年12月，参与项目《数字文化旅游和商业运营融合的集成现代服务云平台》研究，该项目主要是通过蓝牙模块和用户定位信息来向用户提供周边旅游信息服务或者其他的存储好的信息服务，作为项目iOS APP的开发者，取得了一个计算机软件著作权《基于位置服务的周边信息推送软件》，并将软件在APP Store上线，学习到了iOS程序的异步加载图片及iOS本地数据库开发经验；
//2018年3月-2018年11月，参与项目《互联网环境的设备无关扁平化的物联网共性支撑平台》研究，该项目是通过云平台作为中间平台来解耦物联设备和用户程序，消除不同物联设备之间的差异，作为项目参与者，开了作为中间平台的云平台，学习到了基本的Java web开发框架SpringBoot、FreeMarker、Spring Data JPA等，同时使用了DevTools、Lombok等插件来提高开发效率，同时有了一定的MySQL、MongoDB开发的经验，并且承担了项目的iOS端开发任务，取得一个计算机软件著作权《基于物联设备的硬件控制软件》；
}