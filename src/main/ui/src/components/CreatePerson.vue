<template>
  <div class="container">
    <div class="row">
      <div class="col-md-7 mrgnbtm">
        <h2>Create Person</h2>
        <form>
          <div class="row">
            <div class="form-group col-md-6">
              <label htmlFor="exampleInputEmail1">First Name</label>
              <input type="text" class="form-control" v-model="firstName" name="firstname" id="firstname" placeholder="First Name" />
            </div>
            <div class="form-group col-md-6">
              <label htmlFor="exampleInputPassword1">Last Name</label>
              <input type="text" class="form-control" v-model="lastName" name="lastname" id="lastname" placeholder="Last Name" />
            </div>
          </div>
          <div class="row">
            <div class="form-group col-md-12">
              <label htmlFor="exampleInputEmail1">Date Of Birth</label>
              <input type="text" class="form-control" v-model="dateOfBirth" name="dateOfBirth" id="dateOfBirth" placeholder="date of birth" />
            </div>
          </div>
          <button type="button" @click='createPerson()' class="btn btn-danger">Create</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CreatePerson",
  data(){
    return {
      firstName: '',
      lastName: '',
      dateOfBirth: ''
    }
  },

  methods: {
    createPerson(){
      console.log(this.firstName)
      const payload = {
        firstName: this.firstName,
        lastName : this.lastName,
        dateOfBirth : this.dateOfBirth
      }
      this.$emit('createPerson', payload)
      this.clearForm()
    },

    clearForm(){
      this.firstName = "";
      this.lastName = "";
      this.dateOfBirth = "";
    }
  }
}
</script>

<style scoped>

</style>