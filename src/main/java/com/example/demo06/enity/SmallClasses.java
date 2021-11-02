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
@Erupt(name = "班级")
@Table(name = "t_classes")
@Entity
public class SmallClasses {

    @EruptField(
            views = @View(
                    title = "班级编号", sortable = true
            ),
            edit = @Edit(
                    title = "班级编号",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    @Id
    private Integer id;

    @EruptField(
            views = @View(
                    title = "帮扶学科",
                    column = "name"
            ),
            edit = @Edit(
                    title = "帮扶学科",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private Subject helpSubject;

    @EruptField(
            views = @View(
                    title = "小导师",
                    column = "name"
            ),
            edit = @Edit(
                    title = "小导师",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private Teacher teacher;

    @EruptField(
            views = @View(
                    title = "学生"
            ),
            edit = @Edit(
                    title = "学生",
                    type = EditType.TAB_TABLE_REFER, search = @Search, notNull = true
            )
    )
    @ManyToMany
    @JoinTable(name = "small_classes_student",
            joinColumns = @JoinColumn(name = "small_classes_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students;

    @EruptField(
            views = @View(
                    title = "对接干事",
                    column = "name"
            ),
            edit = @Edit(
                    title = "对接干事",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private Clerk clerk;
    @EruptField(
            views = @View(
                    title = "班级名称"
            ),
            edit = @Edit(
                    title = "班级名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

}