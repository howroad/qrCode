package qrCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * <p>Title: CreateTable.java</p>
 *
 * <p>Description: 懒得装Mysql了。。。</p>
 *
 * @author luhao
 * 
 * @since：2019年3月7日 下午5:17:06
 * 
 */
public class CreateTable {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void crTable(String str) {
        Connection conn = null;
        Statement stmt = null;
        String crtables = str;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://43.226.43.150:3306/mysql1903076e9e_db?useUnicode=true&characterEncoding=utf-8", 
                    "mysql1903076e9e", "Howroad0701");
            stmt = conn.createStatement();
            if(0 == stmt.executeLargeUpdate(crtables)) {
                System.out.println("创建成功！");
            }else {
                System.out.println("创建表失败！");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }            
    }
    
    public static void main(String[] args) {
        String crtables1 = 
                "CREATE TABLE `activity`  (" + 
                "  `actId` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动主键'," + 
                "  `actNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动编号'," + 
                "  `actName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动主题'," + 
                "  `actJoinNum` int(11) NULL DEFAULT NULL COMMENT '参与活动人数'," + 
                "  `actState` int(255) NULL DEFAULT NULL COMMENT '活动状态(0,启动;1,进行;2,结束;3,废弃)'," + 
                "  `actStartTime` datetime(0) NULL DEFAULT NULL COMMENT '活动开始时间'," + 
                "  `actEndTime` datetime(0) NULL DEFAULT NULL COMMENT '活动结束时间'," + 
                "  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间'," + 
                "  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间'," + 
                "  PRIMARY KEY (`actId`) USING BTREE" + 
                ") ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;";
        String crtables2 = "CREATE TABLE `user`  (" + 
                "  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键'," + 
                "  `userNo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号'," + 
                "  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名'," + 
                "  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码'," + 
                "  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间'," + 
                "  PRIMARY KEY (`userId`) USING BTREE" + 
                ") ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;" + 
                "";
        String crtables3 = "CREATE TABLE `useractivity`  (" + 
                "  `userActId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键'," + 
                "  `userId` int(11) NULL DEFAULT NULL COMMENT '用户主键'," + 
                "  `actId` int(11) NULL DEFAULT NULL COMMENT '活动主键'," + 
                "  `userActState` int(11) NULL DEFAULT NULL COMMENT '签到状态(0,邀请;1,签到;2,迟到)'," + 
                "  `userActTime` datetime(0) NULL DEFAULT NULL COMMENT '签到时间'," + 
                "  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间'," + 
                "  PRIMARY KEY (`userActId`) USING BTREE" + 
                ") ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;" + 
                "";
        crTable(crtables1);
        crTable(crtables2);
        crTable(crtables3);
    }
}
