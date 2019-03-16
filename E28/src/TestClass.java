import java.util.*;

public class TestClass{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] vis = new int[nums.length];
        permutation(1, nums, vis, listAll, list, nums.length);
        return listAll;
    }

    private void permutation(int k, int[] nums, int[] vis, List<List<Integer>> listAll, List<Integer> list, int length) {
        if (k > length) {
            if (listAll.contains(list)) {
                return;
            }
            listAll.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                list.add(nums[i]);
                permutation(k + 1, nums, vis, listAll, list, length);
                vis[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public static int []num = new int[2005];


    public static void main(String[]  args){
        int[] nums = {1, 1, 3};
        System.out.println(new TestClass().permute(nums));
    }
    //2017年4月-2017年12月，参与项目《数字文化旅游和商业运营融合的集成现代服务云平台》研究，该项目主要是通过蓝牙模块和用户定位信息来向用户提供周边旅游信息服务或者其他的存储好的信息服务，作为项目iOS APP的开发者，取得了一个计算机软件著作权《基于位置服务的周边信息推送软件》，并将软件在APP Store上线，学习到了iOS程序的异步加载图片及iOS本地数据库开发经验；
//2018年3月-2018年11月，参与项目《互联网环境的设备无关扁平化的物联网共性支撑平台》研究，该项目是通过云平台作为中间平台来解耦物联设备和用户程序，消除不同物联设备之间的差异，作为项目参与者，开了作为中间平台的云平台，学习到了基本的Java web开发框架SpringBoot、FreeMarker、Spring Data JPA等，同时使用了DevTools、Lombok等插件来提高开发效率，同时有了一定的MySQL、MongoDB开发的经验，并且承担了项目的iOS端开发任务，取得一个计算机软件著作权《基于物联设备的硬件控制软件》；
}