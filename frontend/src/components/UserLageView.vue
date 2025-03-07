<template>

    <v-data-table
        :headers="headers"
        :items="userLage"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'UserLageView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "windowId", value: "windowId" },
                { text: "userId", value: "userId" },
                { text: "workId", value: "workId" },
                { text: "emailId", value: "emailId" },
                { text: "title", value: "title" },
                { text: "content", value: "content" },
            ],
            userLage : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/userLages'))

            temp.data._embedded.userLages.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.userLage = temp.data._embedded.userLages;
        },
        methods: {
        }
    }
</script>

