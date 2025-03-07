<template>

    <v-card outlined>
        <v-card-title>
            UserLage # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="WindowId" v-model="item.windowId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="WorkId" v-model="item.workId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="EmailId" v-model="item.emailId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Title" v-model="item.title" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Content" v-model="item.content" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'UserLageViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/userLages/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

