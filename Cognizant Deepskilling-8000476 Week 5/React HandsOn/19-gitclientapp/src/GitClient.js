import axios from'axios';export default class GitClient{async getRepositories(user='techiesyed'){let r=await axios.get(`https://api.github.com/users/${user}/repos`);return r.data.map(x=>x.name)}}
