package com.example.demo06.enity;



/*
 * Copyright © 2020-2035 erupt.xyz All rights reserved.
 * Author: YuePeng (erupts@126.com)
 */

import javax.persistence.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

/**
 * @author 小喻同学
 */
@Erupt(name = "学生")
@Table(name = "t_students")
@Entity
public class Student {

    @EruptField(
            views = @View(
                    title = "ID", sortable = true
            ),
            edit = @Edit(
                    title = "ID",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    @Id
    private Integer id;

    @EruptField(
            views = @View(
                    title = "姓名"
            ),
            edit = @Edit(
                    title = "姓名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "学号"
            ),
            edit = @Edit(
                    title = "学号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String number;

    @EruptField(
            views = @View(
                    title = "年级"
            ),
            edit = @Edit(
                    title = "年级",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "大一", label = "大一"),
                            @VL(value = "大二", label = "大二"),
                            @VL(value = "大三", label = "大三"),
                            @VL(value = "大四", label = "大四"),
                    })
            )
    )
    private String grade;

    @EruptField(
            views = @View(
                    title = "电话"
            ),
            edit = @Edit(
                    title = "电话",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String phone;

    @EruptField(
            views = @View(
                    title = "专业"
            ),
            edit = @Edit(
                    title = "专业",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "计算机类", label = "计算机类"),
                            @VL(value = "电子信息类", label = "电子信息类"),
                            @VL(value = "计算机科学与技术", label = "计算机科学与技术"),
                            @VL(value = "物联网", label = "物联网"),
                            @VL(value = "数据科学与大数据技术", label = "数据科学与大数据技术"),
                            @VL(value = "数字媒体技术", label = "数字媒体技术"),
                            @VL(value = "其他", label = "其他")
                    })
            )
    )
    private String major;

    @EruptField(
            views = @View(
                    title = "小导师",
                    column = "name"
            ),
            edit = @Edit(
                    title = "小导师",
                    type = EditType.REFERENCE_TABLE, search = @Search,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private Teacher teacher;

    @EruptField(
            views = @View(
                    title = "班级",
                    column = "name"
            ),
            edit = @Edit(
                    title = "班级",
                    type = EditType.REFERENCE_TABLE, search = @Search,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private SmallClasses classes;

}
