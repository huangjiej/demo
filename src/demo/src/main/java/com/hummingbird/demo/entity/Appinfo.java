package com.hummingbird.demo.entity;

import java.util.Date;

/**
 * 通知模块的app输入
 */
public class Appinfo {
    /**
     * appId
     */
    private String appid;

    /**
     * appName
     */
    private String appname;

    /**
     * appKey
     */
    private String appkey;

    /**
     * appCert
     */
    private String appcert;

    /**
     * insertTime
     */
    private Date inserttime;

    /**
     * updateTime
     */
    private Date updatetime;

    /**
     * 状态,OK#正常，OFF 下线
     */
    private String status;

    /**
     * appPublicKey
     */
    private String apppublickey;

    /**
     * @return appId
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid 
	 *            appId
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * @return appName
     */
    public String getAppname() {
        return appname;
    }

    /**
     * @param appname 
	 *            appName
     */
    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
    }

    /**
     * @return appKey
     */
    public String getAppkey() {
        return appkey;
    }

    /**
     * @param appkey 
	 *            appKey
     */
    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    /**
     * @return appCert
     */
    public String getAppcert() {
        return appcert;
    }

    /**
     * @param appcert 
	 *            appCert
     */
    public void setAppcert(String appcert) {
        this.appcert = appcert == null ? null : appcert.trim();
    }

    /**
     * @return insertTime
     */
    public Date getInserttime() {
        return inserttime;
    }

    /**
     * @param inserttime 
	 *            insertTime
     */
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime 
	 *            updateTime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return 状态,OK#正常，OFF 下线
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status 
	 *            状态,OK#正常，OFF 下线
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return appPublicKey
     */
    public String getApppublickey() {
        return apppublickey;
    }

    /**
     * @param apppublickey 
	 *            appPublicKey
     */
    public void setApppublickey(String apppublickey) {
        this.apppublickey = apppublickey == null ? null : apppublickey.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Appinfo other = (Appinfo) that;
        return (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getAppname() == null ? other.getAppname() == null : this.getAppname().equals(other.getAppname()))
            && (this.getAppkey() == null ? other.getAppkey() == null : this.getAppkey().equals(other.getAppkey()))
            && (this.getAppcert() == null ? other.getAppcert() == null : this.getAppcert().equals(other.getAppcert()))
            && (this.getInserttime() == null ? other.getInserttime() == null : this.getInserttime().equals(other.getInserttime()))
            && (this.getUpdatetime() == null ? other.getUpdatetime() == null : this.getUpdatetime().equals(other.getUpdatetime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getApppublickey() == null ? other.getApppublickey() == null : this.getApppublickey().equals(other.getApppublickey()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getAppname() == null) ? 0 : getAppname().hashCode());
        result = prime * result + ((getAppkey() == null) ? 0 : getAppkey().hashCode());
        result = prime * result + ((getAppcert() == null) ? 0 : getAppcert().hashCode());
        result = prime * result + ((getInserttime() == null) ? 0 : getInserttime().hashCode());
        result = prime * result + ((getUpdatetime() == null) ? 0 : getUpdatetime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getApppublickey() == null) ? 0 : getApppublickey().hashCode());
        return result;
    }
}