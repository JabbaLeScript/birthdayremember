<template>
  <div class="display-board">
    <h4>Persons Created</h4>
    <div class="number">
      {{numberOfPersons}}
    </div>
    <div class="btn">
      <button @click='getAllPersons()' type="button" class="btn btn-warning">Get all Persons</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "DisplayBoard",
  props: ['numberOfPersons'],
  methods: {
    getAllPersons(){
      this.$emit('getALlPersons')
    }
  }
}
</script>

<style scoped>

</style>