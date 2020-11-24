package com.example.broadcastbestpractice

import android.app.Activity

/**
 * Activity管理器
 */
object ActivityCollector {
    private val activities = ArrayList<Activity>()

    /**
     *添加指定的 Activity。。
     */
    fun addActivity(activity: Activity){
        activities.add(activity)
    }

    /**
     * 移除指定的Activity。。
     */
    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }

    /**
     * 销毁所有的Activity。。
     */
    fun finishAll(){
        for (activity:Activity in activities){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }
}