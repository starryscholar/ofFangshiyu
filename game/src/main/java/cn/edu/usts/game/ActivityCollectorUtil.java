package cn.edu.usts.game;

/**
 * Created by 11616 on 2020/4/2.
 */

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;



public class ActivityCollectorUtil {

    public static List<Activity> activities = new ArrayList<Activity>();

    /**
     * 添加新的activity到集合中
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 从集合中移除相应的activity
     *
     * @param activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 关闭所有的活动（activity），即退出程序
     */
    public static void finishAllActivity() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}

