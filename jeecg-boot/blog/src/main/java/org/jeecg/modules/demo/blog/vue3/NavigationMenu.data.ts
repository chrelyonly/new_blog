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
    title: '跳转路径',
    align:"center",
    dataIndex: 'path'
   },
   {
    title: '图标',
    align:"center",
    dataIndex: 'icon'
   },
   {
    title: '图标颜色',
    align:"center",
    dataIndex: 'iconBgColor'
   },
   {
    title: '父级id',
    align:"center",
    dataIndex: 'parentId'
   },
   {
    title: '子集',
    align:"center",
    dataIndex: 'children'
   },
   {
    title: '是否有子集',
    align:"center",
    dataIndex: 'boobleChildren'
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
    label: '跳转路径',
    field: 'path',
    component: 'Input',
  },
  {
    label: '图标',
    field: 'icon',
    component: 'Input',
  },
  {
    label: '图标颜色',
    field: 'iconBgColor',
    component: 'Input',
  },
  {
    label: '父级id',
    field: 'parentId',
    component: 'Input',
  },
  {
    label: '子集',
    field: 'children',
    component: 'Input',
  },
  {
    label: '是否有子集',
    field: 'boobleChildren',
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
