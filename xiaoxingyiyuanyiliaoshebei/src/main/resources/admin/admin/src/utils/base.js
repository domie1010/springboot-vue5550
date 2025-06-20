const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoxingyiyuanyiliaoshebei/",
            name: "xiaoxingyiyuanyiliaoshebei",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoxingyiyuanyiliaoshebei/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "小型医院医疗设备管理系统"
        } 
    }
}
export default base
