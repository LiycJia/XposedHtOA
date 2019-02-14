package top.programan.xposedht

import android.content.Context
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by lilijia on 2019/2/13.
 * @description
 */
class XposedUtil : IXposedHookLoadPackage {
    private val packageName = "com.huatu.htmoa"
    private val param = "com.huatu.htmoa.manage.a.c.a().c().userNameSpelling"
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        //判断应用包名
        if (lpparam?.packageName == packageName) {
            XposedBridge.log("华图教育OA——包名")
            //找到对应的类并hook掉对应的方法
            //
            //   * @param className The name of the class which implements the method.需要全路径
            //	 * @param classLoader The class loader for resolving the target and parameter classes.类加载器
            //	 * @param methodName The target method name.方法名
            //   * @param parameterTypesAndCallback The parameter types of the target method, plus the callback.hook
            //      hook方法参数+方法处理
//            XposedHelpers.findAndHookMethod("com.huatu.htmoa.ui.splash.c", lpparam.classLoader, "c",
//                object : XC_MethodHook() {
//                    @Throws(Throwable::class)
//                    override fun afterHookedMethod(param: XC_MethodHook.MethodHookParam?) {
//                        //hook后操作
//                        XposedBridge.log("华图教育OA_监控")
//
////                        XposedHelpers.findAndHookMethod("com.huatu.htmoa.manage.a.c",lpparam.classLoader,"a"
////                        ,)
//                        val clazz = XposedHelpers.findClass("com.huatu.htmoa.manage.a.c", lpparam.classLoader)
//
//                        XposedHelpers.setObjectField(
//                            XposedHelpers.findField(clazz, "b.a"), "userNameSpelling", "yidh")
////                        val spellName = XposedHelpers.findField()
//                    }
//                })
            XposedHelpers.findAndHookMethod("com.huatu.htmoa.manage.a.c", lpparam.classLoader, "a",
                XposedHelpers.findClass("com.huatu.htmoa.manage.entity.entity.User", lpparam.classLoader),
                object : XC_MethodHook() {
                    override fun beforeHookedMethod(param: MethodHookParam?) {
                        super.beforeHookedMethod(param)

                        XposedBridge.log("华图教育OA_监控")
                        XposedHelpers.setObjectField(param!!.args[0], "userNameSpelling", "zhangsy")
                        XposedHelpers.setObjectField(param.args[0], "userId", "33523")
                        XposedBridge.log("--------------")
                    }
                })
        }
    }

}