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
@Erupt(name = "干事")
@Table(name = "t_clerks")
@Entity
public class Clerk{

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
                    title = "联系电话"
            ),
            edit = @Edit(
                    title = "联系电话",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String phone;

    @EruptField(
            views = @View(
                    title = "对接小导师",
                    column = "name"
            ),
            edit = @Edit(
                    title = "对接小导师",
                    type = EditType.REFERENCE_TABLE, search = @Search, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private Teacher teacher;

    @EruptField(
            views = @View(
                    title = "对接班级"
            ),
            edit = @Edit(
                    title = "对接班级",
                    type = EditType.TAB_TABLE_REFER, search = @Search, notNull = true
            )
    )
    @ManyToMany
    @JoinTable(name = "clerk_small_classes",
            joinColumns = @JoinColumn(name = "clerk_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "small_classes_id", referencedColumnName = "id"))
    private Set<SmallClasses> smallClass;

}