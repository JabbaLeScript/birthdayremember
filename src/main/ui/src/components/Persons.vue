<template>
  <div class="container">
    <h2>Persons</h2>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>Person Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Date of Birth</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in persons" :key="item.id">
        <td>{{ item.id }}</td>
        <td>{{ item.firstName }}</td>
        <td>{{ item.lastName }}</td>
        <td>{{ item.dateOfBirth }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "Persons",
  props: ['persons']
}
</script>

<style scoped>

</style>