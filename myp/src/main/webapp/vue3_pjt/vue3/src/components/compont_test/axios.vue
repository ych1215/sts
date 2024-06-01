  
 <template>
  <button @click="fetchPosts">axios통신</button>
  <div v-for="post in users">
    <h2>{{ post.title }}</h2>
    <p>{{ post.body }}</p>
  </div>
</template>


<script>
import axios from "axios";

export default {
  data() {
    return {
      users: [],
    };
  },

  methods: {
    fetchPosts() {
      var my = this; // Vue의 this를 저장 한다. axios안에서 this는 Vue의 this가 아니므로.  화설표 함수를 쓰면 this 써도 되는듯.
      //https://jsonplaceholder.typicode.com/todos/1   // 1건 짜리
      axios
        .get("https://jsonplaceholder.typicode.com/posts")
        .then(function (response) {
          console.log(response.data);
          my.users = response.data;
          // this.users = response.data; // 여기서 this는 axios의 디스 이다.
        })
        .chtch(function (error) {
          console.log(response);
        });
    },
  },
};
</script>

<style scoped>
</style>