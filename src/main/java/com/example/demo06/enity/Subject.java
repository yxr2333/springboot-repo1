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
@Erupt(name = "学科")
@Table(name = "t_subject")
@Entity
public class Subject extends BaseModel {

    @EruptField(
            views = @View(
                    title = "学科名称"
            ),
            edit = @Edit(
                    title = "学科名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

}