const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot97q29tbg/",
            name: "springboot97q29tbg",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot97q29tbg/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "酒店管理系统"
        } 
    }
}
export default base
