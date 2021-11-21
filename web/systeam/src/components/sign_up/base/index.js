import { reactive } from 'vue'
// const cityOptions = ['大一', '大二', '大三', '大四']
export const ruleCont = reactive({
  ruleForm: {
    name: '',
    number: '',
    regionOne: '',
    regionTwo: '',
    phone: '',
    qq: '',
    gropitem: [],
    gropitems: []
  },
  rules: {
    name: [
      {
        required: true,
        message: 'Please input Activity name',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 5,
        message: 'Length should be 3 to 5',
        trigger: 'blur'
      }
    ],
    number: [
      {
        required: true,
        message: 'Please input Activity Student number',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 5,
        message: 'Length should be 3 to 5',
        trigger: 'blur'
      }
    ],
    regionOne: [
      {
        required: true,
        message: 'Please select Activity zone',
        trigger: 'change'
      }
    ],
    regionTwo: [
      {
        required: true,
        message: 'Please select Activity zone',
        trigger: 'change'
      }
    ],
    phone: [
      {
        required: true,
        message: 'Please input Activity phone',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 5,
        message: 'Length should be 3 to 5',
        trigger: 'blur'
      }
    ],
    qq: [
      {
        required: true,
        message: 'Please input Activity qq',
        trigger: 'blur'
      },
      {
        min: 3,
        max: 5,
        message: 'Length should be 3 to 5',
        trigger: 'blur'
      }
    ]
  }
})
