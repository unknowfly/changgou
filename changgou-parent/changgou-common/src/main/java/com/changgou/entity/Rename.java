package com.changgou.entity;

import java.io.File;

/**
 * @author zsh
 * @site https://qqzsh.top
 * @create 2020-02-06 11:58
 * @Description 批量修改文件名称
 */
public class Rename {

    //新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
    static String newString = "";
    //要被替换的字符串
    static String oldString = "【瑞客论 坛 www.ruike1.com】";
    //文件所在路径，所有文件的根目录
    static String dir = "F:\\BaiduNetdiskDownload\\image\\";

    public static void main(String[] args) {
        //递归遍历此路径下所有文件夹
        recursiveTraversalFolder(dir);
    }

    /**
     * 递归遍历文件夹获取文件
     */
    public static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                //文件所在文件夹路径+新文件名
                File newDir = null;
                //新文件名
                String newName = "";
                //旧文件名
                String fileName = null;
                //文件所在父级路径
                File parentPath = new File("");
                for (File file : fileArr) {
                    if (file.isDirectory()) {
                        //是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                        System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                        recursiveTraversalFolder(file.getAbsolutePath());
                    } else {
                        //是文件，判断是否需要重命名
                        fileName = file.getName();
                        parentPath = file.getParentFile();
                        //文件名包含需要被替换的字符串
                        if (fileName.contains(oldString)) {
                            //新名字
                            newName = fileName.replaceAll(oldString, newString);
                            //文件所在文件夹路径+新文件名
                            newDir = new File(parentPath + "/" + newName);
                            //重命名
                            file.renameTo(newDir);
                            System.out.println("修改后：" + newDir);
                        }
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}