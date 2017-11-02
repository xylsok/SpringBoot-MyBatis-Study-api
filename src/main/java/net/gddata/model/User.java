package net.gddata.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhangzf on 17/10/25.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer ID;
    private String username;
    private String password;
    private String mac;
    private String level;
    private String department;
}
