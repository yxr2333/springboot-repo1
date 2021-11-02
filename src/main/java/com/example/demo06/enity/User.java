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
@Erupt(name = "用户")
@Table(name = "t_users")
@Entity
public class User{

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
                    title = "电话"
            ),
            edit = @Edit(
                    title = "电话",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String phone;

}