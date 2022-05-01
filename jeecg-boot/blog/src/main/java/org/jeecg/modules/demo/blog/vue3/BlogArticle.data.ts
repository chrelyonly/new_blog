import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
    {
    title: '文章标题',
    align:"center",
    dataIndex: 'articleName'
   },
   {
    title: '文章logo',
    align:"center",
    dataIndex: 'articleLogo'
   },
   {
    title: '文章内容',
    align:"center",
    dataIndex: 'articleText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '文章标题',
    field: 'articleName',
    component: 'Input',
  },
  {
    label: '文章logo',
    field: 'articleLogo',
    component: 'Input',
  },
  {
    label: '文章内容',
    field: 'articleText',
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
