import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
    {
    title: '标题',
    align:"center",
    dataIndex: 'title'
   },
   {
    title: '图标',
    align:"center",
    dataIndex: 'icon'
   },
   {
    title: '文本',
    align:"center",
    dataIndex: 'footText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '标题',
    field: 'title',
    component: 'Input',
  },
  {
    label: '图标',
    field: 'icon',
    component: 'Input',
  },
  {
    label: '文本',
    field: 'footText',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
