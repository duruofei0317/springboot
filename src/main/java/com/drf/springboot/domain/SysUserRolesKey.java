package com.drf.springboot.domain;

public class SysUserRolesKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_roles.role_id
     *
     * @mbggenerated Tue Dec 26 22:22:56 GMT+08:00 2017
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_roles.user_id
     *
     * @mbggenerated Tue Dec 26 22:22:56 GMT+08:00 2017
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_roles.role_id
     *
     * @return the value of sys_user_roles.role_id
     *
     * @mbggenerated Tue Dec 26 22:22:56 GMT+08:00 2017
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_roles.role_id
     *
     * @param roleId the value for sys_user_roles.role_id
     *
     * @mbggenerated Tue Dec 26 22:22:56 GMT+08:00 2017
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_roles.user_id
     *
     * @return the value of sys_user_roles.user_id
     *
     * @mbggenerated Tue Dec 26 22:22:56 GMT+08:00 2017
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_roles.user_id
     *
     * @param userId the value for sys_user_roles.user_id
     *
     * @mbggenerated Tue Dec 26 22:22:56 GMT+08:00 2017
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}